# Install Java
sudo yum -y install java-1.8.0-openjdk.x86_64
sudo yum -y install java-1.8.0-openjdk-devel.x86_64

# Install Scala
wget http://downloads.typesafe.com/scala/2.11.7/scala-2.11.7.tgz
tar xvzf scala-2.11.7.tgz
sudo mv scala-2.11.7 /usr/local/scala

# Install SBT
curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo
sudo yum -y install sbt

# Add Environment(temporary)
export PATH=$PATH:/usr/local/scala/bin
echo $PATH

# 上記のコマンドを /etc/profile の最終行に追記する
# そうすることで常に環境変数が設定される
