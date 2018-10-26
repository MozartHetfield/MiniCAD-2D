    NUME: SOARE ION-ALEXANDRU
    UNIVERSITATEA: POLITEHNICA DIN BUCURESTI
    FACULTATEA: AUTOMATICA SI CALCULATOARE, SECTIA CTI
    GRUPA SI SERIA: 323, CD
    ANUL UNIVERSITAR: 2017-2018

-----------------	 TEMA 2 - MINI AUTOCAD	 -----------------

Proiectul cuprinde 14 clase si 3 interfete, grupate toate in pachetul
forms, cu exceptia clasei Main, dorita separat datorita enuntului. Voi prezenta
intreg decursul Main-ului, oprind pentru a detalia ce necesita explicatii suplimentare.
	Main-ul debuteaza cu 3 obiecte din clase de tipul Singleton Pattern,
si anume: ShapeFactory, DrawFigure si FillFigure, urmate de un scanner
si de o variabila de tip File care va reprezenta output-ul dorit. Cu ajutorul
scanner-ului, se vor citi numarul de forme, respectiv caracteristicile Canvas-ului,
folosindu-se metode auxiliare, cum ar fi scanf.nextLine() pentru a trece pe linia
urmatoare cand nu mai dorim nimic de pe cea curenta, ori split-uirea intregului sir
dupa caracterul spatiu (" "), pentru a folosi parametrii pe rand, prin interme-
diul unui vector de sir-uri (parts). Se va crea o image de tip BufferedImage, de
culoare ARGB, denumita image, ale carei culoare de fundal va si setata in functie
de dimensiunile Canvas-ului si de culoarea acestuia. De specificat este ca, pe intreg
decursul temei, metodele s-au folosit de x ca fiind numarul de linii, iar y numa-
rul de coloane. Astfel, la setarea RGB-ului imaginii, se vor inversa pentru a
genera imaginea dorita. Pentru descifrarea imaginii, am folosit functia 
translateImage din clasa ShapeFactory, care muta, dupa parsarea string-ului RGB
la int, pe primul byte cel mai semnificativ (primul din patru), numarul de o-
pacitate (pe scurt, shifteaza cu 24 de pozitii valoarea din alpha, urmand sa o a-
dune cu restul numarului convertit zecimal). Dupa ce am terminat cu fundalul, 
vom parcurge un for pentru a desena restul formelor ramase. Pentru fiecare tre-
cere prin for, se verifica ce tip de forma este, prin intermediul primului string
(exemplue: "LINE", ignorand majusculele/minusculele), urmand sa se creeze un o-
biect de tipul respectiv cu ajutorul creator-ului, fiindu-i atribuite atri-
butiile prin constructor. Utilizarea constructorului este datorata usurintei
si scrierii compacte a codului, evitand, astfel, o inlantuire de setteri.
	Dupa atribuire, se foloseste pattern-ul visitor, unde accepta drawer-ul.
Mecanismul pentru transpunerea formelor pe imagine este de a umple o matrice
statica (din clasa ShapeClasS), de dimensiunile Canvas-ului, pe care o vom
altera prin fiecare forma, intrucat fiecare forma extinde clasa ShapeClass.
Pentru desenare, matricea se va umple cu 42, iar pentru fill cu 13. Astfel,
se diferentiaza conturul de culoarea de fill (matricea avand 0 pe fiecare
pozitie cand e nealterata). Asadar, la fiecare forma, se va completa ma-
tricea cu 42 (conturul), urmand sa coloreze imaginea cu conturul prin
functia draw apelata pe canvas (supraincarcare din ShapeClass). Dupa
aceea, se va completa cu 13 tot interiorul formei, pentru a completa
culoarea cu functia fill, apelata de acelasi Canvas. De asemenea,
la inceputul for-ului, se umple iar matricea cu 0-uri, pentru a nu interpune
desenarea/umplerea simultana a doua sau mai multe forme.
	Este folosita interfata Shape, ce extinde Visitable pentru ca fiecare 
forma sa poata sa fie apelata de un visitor (drawer si filler). Draw-ul are
o metode de visit pentru fiecare forma. Line si Circle prezinta implemen-
tari de pe site, iar restul se bazeaza pe trasarea mai multor linii. De specificat
este ca poligonul are in clasa sa doi vectori ce reprezinta coordonatele X, respectiv Y
ale punctelor, grupate impreuna dupa indicii comuni (coordonateX[i], coordonateY[i]),
iar punctul de pornire pentru fill este media lor aritmetica.
	Algoritmul de fill foloseste Queue, datorita complexitatii ridicate de care
dispune in cazul recursivitatii. Clasa Point este auxiliara, folosind un
singur obiect de tip Point(x,y) pentru stocarea coordonatelor.  
