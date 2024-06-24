# MiniCad
Questo progetto è un interprete di comandi scritto in Java .

## Caratteristiche

- Semplice interfaccia a riga di comando.
- Possibilità di vedere istantaneamente le modifiche apportate.
- Pulsante "undo" che permette di visualizzare lo stato precedente.

## Requisiti

- Avere un IDE che supporti Java.

## Installazione

1. Clona il repository:
    ```sh
    git clone https://github.com/MysticGabry/minicad_project_240475.git
    ```
2. Apri un IDE a tua scelta (ad esempio IntelliJ IDEA, Eclipse, NetBeans, ecc...);

3. Importa il progetto in un IDE a tua scelta (Intellij IDEA, Eclipse, ecc);

4. Vai nel package "main", trova la Classe "Main", e avviala facendo un click col tasto destro del mouse, selezionando 'Run Main.main()'.

5. Inserisci i comandi e inizia a disegnare!


## Utilizzo
Di seguito alcuni comandi di esempio, da inserire nel prompt centrale presente sul pannello di visualizzazione: 
-    new circle (100.0) (300.0,200.0)
-    new rectangle (120.0,200.0) (430.0,220.0)
-    new img "C:\\Users\\Utente\\Desktop\\prova.jpg" (321.5,220.0)

-    del Circle1
-    del Rectangle3
-    del Image5

-    mv Image1 (140.0,260.0)
-    scale Circle1 27.3
-    ls Rectangle1

-    ...
    

## Esempio del Main

Ecco un esempio del `Main`:

```java
package main;

import graphicsViewComponent.GraphicFrame;

public class Main {
    public static void main(String... args) {
        GraphicFrame.getInstance();
    }
}
