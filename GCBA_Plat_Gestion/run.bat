set ProjectPath=C:\Projects\GCBA_Plat_Gestion
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
java org.testng.TestNG C:\Projects\GCBA_Plat_Gestion\PIG_Config.xml
pause