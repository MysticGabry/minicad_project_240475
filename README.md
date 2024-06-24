# Command Interpreter

Questo progetto è un interprete di comandi scritto in Java. L'interprete consente di eseguire comandi da una riga di comando personalizzata.

## Caratteristiche

- Esecuzione di comandi predefiniti.
- Estensibile con nuovi comandi.
- Semplice interfaccia a riga di comando.

## Requisiti

- Java 11 o superiore.

## Installazione

1. Clona il repository:
    ```sh
    git clone https://github.com/tuo-username/command-interpreter.git
    ```
2. Naviga nella directory del progetto:
    ```sh
    cd command-interpreter
    ```
3. Compila il progetto:
    ```sh
    javac -d out src/main/java/com/example/commandinterpreter/*.java
    ```

## Utilizzo

1. Avvia l'interprete di comandi:
    ```sh
    java -cp out com.example.commandinterpreter.Main
    ```
2. Digita i comandi nella riga di comando. Per esempio:
    ```sh
    > help
    > exit
    ```

## Esempio di codice

Ecco un esempio di come il metodo `main` potrebbe apparire:

```java
package com.example.commandinterpreter;

public class Main {
    public static void main(String[] args) {
        CommandInterpreter interpreter = new CommandInterpreter();
        interpreter.start();
    }
}