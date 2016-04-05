package slickPractice
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.PostgresDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Coffees.schema ++ Suppliers.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Coffees
   *  @param cofName Database column COF_NAME SqlType(varchar), PrimaryKey
   *  @param supId Database column SUP_ID SqlType(int4)
   *  @param price Database column PRICE SqlType(float8)
   *  @param sales Database column SALES SqlType(int4)
   *  @param total Database column TOTAL SqlType(int4) */
  case class CoffeesRow(cofName: String, supId: Int, price: Double, sales: Int, total: Int)
  /** GetResult implicit for fetching CoffeesRow objects using plain SQL queries */
  implicit def GetResultCoffeesRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Double]): GR[CoffeesRow] = GR{
    prs => import prs._
    CoffeesRow.tupled((<<[String], <<[Int], <<[Double], <<[Int], <<[Int]))
  }
  /** Table description of table COFFEES. Objects of this class serve as prototypes for rows in queries. */
  class Coffees(_tableTag: Tag) extends Table[CoffeesRow](_tableTag, "COFFEES") {
    def * = (cofName, supId, price, sales, total) <> (CoffeesRow.tupled, CoffeesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(cofName), Rep.Some(supId), Rep.Some(price), Rep.Some(sales), Rep.Some(total)).shaped.<>({r=>import r._; _1.map(_=> CoffeesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column COF_NAME SqlType(varchar), PrimaryKey */
    val cofName: Rep[String] = column[String]("COF_NAME", O.PrimaryKey)
    /** Database column SUP_ID SqlType(int4) */
    val supId: Rep[Int] = column[Int]("SUP_ID")
    /** Database column PRICE SqlType(float8) */
    val price: Rep[Double] = column[Double]("PRICE")
    /** Database column SALES SqlType(int4) */
    val sales: Rep[Int] = column[Int]("SALES")
    /** Database column TOTAL SqlType(int4) */
    val total: Rep[Int] = column[Int]("TOTAL")

    /** Foreign key referencing Suppliers (database name SUP_FK) */
    lazy val suppliersFk = foreignKey("SUP_FK", supId, Suppliers)(r => r.supId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Coffees */
  lazy val Coffees = new TableQuery(tag => new Coffees(tag))

  /** Entity class storing rows of table Suppliers
   *  @param supId Database column SUP_ID SqlType(int4), PrimaryKey
   *  @param supName Database column SUP_NAME SqlType(varchar)
   *  @param street Database column STREET SqlType(varchar)
   *  @param city Database column CITY SqlType(varchar)
   *  @param state Database column STATE SqlType(varchar)
   *  @param zip Database column ZIP SqlType(varchar) */
  case class SuppliersRow(supId: Int, supName: String, street: String, city: String, state: String, zip: String)
  /** GetResult implicit for fetching SuppliersRow objects using plain SQL queries */
  implicit def GetResultSuppliersRow(implicit e0: GR[Int], e1: GR[String]): GR[SuppliersRow] = GR{
    prs => import prs._
    SuppliersRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table SUPPLIERS. Objects of this class serve as prototypes for rows in queries. */
  class Suppliers(_tableTag: Tag) extends Table[SuppliersRow](_tableTag, "SUPPLIERS") {
    def * = (supId, supName, street, city, state, zip) <> (SuppliersRow.tupled, SuppliersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(supId), Rep.Some(supName), Rep.Some(street), Rep.Some(city), Rep.Some(state), Rep.Some(zip)).shaped.<>({r=>import r._; _1.map(_=> SuppliersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SUP_ID SqlType(int4), PrimaryKey */
    val supId: Rep[Int] = column[Int]("SUP_ID", O.PrimaryKey)
    /** Database column SUP_NAME SqlType(varchar) */
    val supName: Rep[String] = column[String]("SUP_NAME")
    /** Database column STREET SqlType(varchar) */
    val street: Rep[String] = column[String]("STREET")
    /** Database column CITY SqlType(varchar) */
    val city: Rep[String] = column[String]("CITY")
    /** Database column STATE SqlType(varchar) */
    val state: Rep[String] = column[String]("STATE")
    /** Database column ZIP SqlType(varchar) */
    val zip: Rep[String] = column[String]("ZIP")
  }
  /** Collection-like TableQuery object for table Suppliers */
  lazy val Suppliers = new TableQuery(tag => new Suppliers(tag))
}
