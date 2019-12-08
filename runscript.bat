@Echo off
SET LOGFILE=C:\Users\pramod.k\eclipse-workspace\APT_Automation_M1\TestLog.log
call :Logit >> %LOGFILE%
exit /b 0
:Logit
set projectpath=C:\Users\pramod.k\eclipse-workspace\APT_Automation_M1
cd %projectpath%
set classpath=%projectpath%\bin;%projectpath%\lib\*
java org.testng.TestNG %projectpath%\testng.xml
pause