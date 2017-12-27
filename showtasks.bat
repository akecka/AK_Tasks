call runcrud.bat
sleep 13
if "%ERRORLEVEL%" == "0" goto startPage
echo.
echo RUNCRUD has errors - canceled
goto errRunCrud

:startPage
start microsoft-edge:http://localhost:8080/crud/v1/task/getTasks
goto end

:errRunCrud
echo runcrud failed
goto end

:end
echo.
echo showtasks is finished.