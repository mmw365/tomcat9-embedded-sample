# Embedded Tomcat (Vesion 9.*) を使ったWebアプリケーションのサンプル

## 使い方
* Mavenでビルド（package）すると、依存するライブラリを含んだJarが作成されます。
* Jarを指定して実行するだけでWebアプリケーションが起動します。
* Java 8 以降対応

## 起動方法

jarを作成して下のコマンドを実行します。
```
java -jar tomcat9-embedded-sample-0.0.1-SNAPSHOT.jar
```
Windows環境で実行する場合は、エンコーディングの指定が必要かもしれません。
```
chcp 65001
java -Dfile.encoding=UTF-8 -jar tomcat9-embedded-sample-0.0.1-SNAPSHOT.jar
```
