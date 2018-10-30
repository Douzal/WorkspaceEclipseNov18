REM open with / text editor pour saisir le script sous eclipse
REM open with / system editor pour lancer le script sous eclipse

cd /d "%~dp0"
set WSDL_URL=http://localhost:8080/servSoap/serviceDevise?wsdl
REM wsimport est dans le répertoire bin du jdk >=1.6 (normalement déjà dans %PATH%)
REM on veut générer le code dans main/java, d'ou :
wsimport -keep -d ./main/java %WSDL_URL%
REM -keep pour garder le code source

pause

REM si ça marche, ca génère du code dans Eclipse
REM "refresh" eclopse pour visualiser le code généré par wsimport