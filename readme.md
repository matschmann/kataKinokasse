# Kinokasse Kata

Aufgabenstellung unter https://app.box.com/s/zl24odq2jlph1r19qh3hhhbzh54ir7fp

## Implementierung

## Aufbau
Die Anwendung wird frontendseitig als AngularJS-Applikation gebaut. Der Server ist in Java 8 implementiert. Vom Backend wird dazu ein Rest-Webservice zur Verfügung gestellt. Die Server-Anwendung erfordert keinen Application-Server, sondern wird als einfache Konsolenapplikation gestartet.

## Server

Zur Zeit wird nur eine Mock-Anwendung zur Verfügung gestellt. Die zurückgelieferten Daten sind alle in der Klasse _de.hundertneun.repository.MockRepository_ definiert. 
Als Rest- und Json-Provider wird jersey verwendet. 

## Client 
-- noch nicht implementiert --

## Offene Punkte

- Einlesen der Film- und Saaldaten aus den in der Aufgabenstellung angegeben Textdateien
- Browserseitige Client-App
- Reservierung und Bezahlung eines Sitzplatzes



## Start der Anwendung

Das Starten der Anwedung ist zur Zeit nur über die IDE möglich. Dafür muss die Klasse __de.hundertneun.App__ mit den in der __pom.xml__ angegebenen Abhängigkeiten im Classpath angegeben werden. 

## Testen der Anwendung 
Zur Zeit lassen sich alle Filme und die dazugehörigen Vorstellungen anzeigen: 

http://localhost:8081/movies

http://localhost:8081/shows/<Filmname>  z.b. http://localhost:8081/shows/Alice

