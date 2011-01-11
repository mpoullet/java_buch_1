import java.util.*;
interface Tabelle{
   final static Object rows[][] = {
      {"Jung", "Daniel", new Date(84,5,23), 23, 180.0},
      {"Jung", "Andrea", new Date(85,1,23), 22, 173.0},
      {"Jung", "Claudia", new Date(79,11,26), 27, 175.54},
      {"Jung", "Lucian", new Date(69,8,25), 37, 177.0},
      {"Michel", "Maren", new Date(76,8,9), 30, 160.0},
      {"Sajnowitz", "Alexander", new Date(87,1,06), 20, 178.45},
      {"Sajnowitz", "Maximilian", new Date(95,10,13), 12, 99.99},
   };
   final static String columns[] = 
      {"Name", "Vorname", "Geburtsdatum", "Alter", "Groesse"};
} 
