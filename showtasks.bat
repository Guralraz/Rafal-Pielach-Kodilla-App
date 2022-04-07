start E:\Development\Projects\Tasks\runcrud.bat
if "%ERRORLEVEL%" == "0" goto firelocalhost
echo.
echo Cannot open localhost
goto end

:firelocalhost
start "" http://localhost:8080/crud/v1/task/getTasks
echo.
echo localhost:8080 opened succesfully

:end
echo.
echo Work is finished