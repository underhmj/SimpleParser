# SimpleParser

This is a simple Maven CLI project that uses Java 11.  In order to run, please make sure that you have both Maven and
Java installed onto your machine. (And yes... for how simple of a project this is, it is intentionally over-engineered to
display a few different areas.)

## Configuring the Parser for Your Files
Inside of the Main class, you will see a simple switch statement.  This statement builds four different parsers: 'FolderFileLeft',
'FolderFileRight', 'FileLeft', and 'FileRight'. If you choose 'FolderFileLeft' or 'FolderFileRight' the parser will first
look for folders as given in the FinderConfigs, then target the files by the same configurations.  It will either grab the
characters on the left of the right of the delimiter depending on the argument you selected.
If you select 'FileLeft' or 'FileRight' the parser will not look for folders, and will not enter any folders. It will simply
parse the files in the single folder that it is running in or pointed to.

Each parser has configurations that are statically set up from the **StandardConfiguration** class in
the same named directory.  As it is, all of the parsers have the same configurations, but you can change them to a path
on your machine, or keep them to run relative to where you place the .JAR.

>If you choose to keep the path the same (relative path) then you must place the .JAR into the folder that you would like
>to begin the search for the subfolders.  

If you would like some sample data to run this on, a folder structure with sample .txt files are located
at *SimpleParser/test/SampleToRun*.  This uses the same data as the unit tests, so you must simply copy and paste them onto
your machine. If you do not want to make any changes to the configurations, simply place the .JAR in the SampleToRun directory.
*You will see there is a file in there called 'PlaceJavaHere.txt' so that you can be sure it is in the proper location for relative
configuration.*

## How to Run the Project
### How to Build the .JAR
Because this is a Maven project, you must first build the .JAR that will be ran.  To begin, please open a command prompt
in the SimpleParser folder. If you `ls` in this folder, you should be able to see the file **pom.xml**. When you are in 
the proper folder please run the following command:
``` bash
mvn clean install 
```
If it is your first time running this command on the project, you will see that a new folder was created in the *SimpleParser*
folder.  This folder is called **target**.  In this folder you will see two .JAR files that were packaged containing our
program.  We will be using **SimpleParser-{VERSION}.jar**.

### How to Run the .JAR
After running the Maven command, the .JAR file has all of the logic and packages from the project at the time you built it.
So, if you make any other changes, you will have to run the Maven command again.  If you are using the sample data, and using
the default relative path configuration, then simply copy and paste the .JAR into the SampleToRun folder.

When you have it in the folder, open a command prompt in that folder and execute the following:
``` bash
java -jar SimpleParser-{VERSION}.jar arg1, arg2, argN, ...
```
The args in this case can be: 'FolderFileLeft', 'FolderFileRight', 'FileLeft', and/or 'FileRight' (or anything you may 
add to the switch statement in the Main class). The program can take a single argument, or multiple.  It will produce a 
summary text file (or multiple... depending on how many arguments) with the same name as the argument and the datetime 
appended.  These summary files will be made in a folder called **Summary**. If the folder you are running this in does 
not have this folder, it will create it when the program runs.