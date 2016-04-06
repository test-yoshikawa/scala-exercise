package slickPractice

import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * Slick Example
 */
object Example extends App {
  val db = Database.forConfig("pg_database")  //　resources/application.confから読み取り（typesafe configライブラリによる）
  println("databesa config: " + db)

  try {
    // Definition of the SUPPLIERS table
    val suppliers = TableQuery[Suppliers]

    // Definition of the COFFEES table
    val coffees = TableQuery[Coffees]

    // Read all coffees and print them to the console
    println("Coffees:")
    db.run(coffees.result).map(_.foreach {
      case (name, supID, price, sales, total) =>
        println("  " + name + "\t" + supID + "\t" + price + "\t" + sales + "\t" + total)
    })

    // Why not let the database do the string conversion and concatenation?
    val q1 = for(c <- coffees)
      yield LiteralColumn("  ") ++ c.name ++ "\t" ++ c.supID.asColumnOf[String] ++
        "\t" ++ c.price.asColumnOf[String] ++ "\t" ++ c.sales.asColumnOf[String] ++
        "\t" ++ c.total.asColumnOf[String]
    // The first string constant needs to be lifted manually to a LiteralColumn
    // so that the proper ++ operator is found
    val a = q1.result
    val f = db.run(a)

    // Equivalent SQL code:
    // select '  ' || COF_NAME || '\t' || SUP_ID || '\t' || PRICE || '\t' SALES || '\t' TOTAL from COFFEES
    db.stream(q1.result).foreach(println)
    println()
    println("select '  ' || COF_NAME || '\t' || SUP_ID || '\t' || PRICE || '\t' SALES || '\t' TOTAL from COFFEES")

    // Perform a join to retrieve coffee names and supplier names for
    // all coffees costing less than $9.00
    val q2 = for {
      c <- coffees if c.price < 9.0
      s <- suppliers if s.id === c.supID
    } yield (c.name, s.name)
    // Equivalent SQL code:
    // select c.COF_NAME, s.SUP_NAME from COFFEES c, SUPPLIERS s where c.PRICE < 9.0 and s.SUP_ID = c.SUP_ID
    db.stream(q2.result).foreach(println)
    println()
    println("select c.COF_NAME, s.SUP_NAME from COFFEES c, SUPPLIERS s where c.PRICE < 9.0 and s.SUP_ID = c.SUP_ID")

    val q3 = for {
      c <- coffees if c.supID =!= 101
      s <- c.supplier
    } yield (c.name, s.name)
    // Equivalent SQL code:
    // select c.COF_NAME, s.SUP_NAME from COFFEES c, SUPPLIERS s where c.SUP_ID <> 101 and s.SUP_ID = c.SUP_ID
    db.stream(q3.result).foreach(println)
    println()
    println("select c.COF_NAME, s.SUP_NAME from COFFEES c, SUPPLIERS s where c.SUP_ID <> 101 and s.SUP_ID = c.SUP_ID")

    val q4 = sql"""
      select
        c."COF_NAME", s."SUP_NAME"
      from "COFFEES" as c, "SUPPLIERS" as s
      where c."SUP_ID" = 150 and s."SUP_ID" = c."SUP_ID"
    """.as[(String, String)]
    val f2 = db.run(q4)
    println()
    println("(Plain Query) select c.COF_NAME, s.SUP_NAME from COFFEES as c, SUPPLIERS as s where c.SUP_ID = 150 and s.SUP_ID = c.SUP_ID")
    Await.result(f2, Duration.Inf).foreach(println)
  } finally db.close
}