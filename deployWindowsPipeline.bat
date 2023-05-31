echo off
echo Running Windows Deploy Pipeline - Must be run in POWERSHELL

set "PROJECT_NAME=unitproject2"
set "GITHUB_USERNAME=yourgithubusername"

if %GITHUB_USERNAME%==yourgithubusername (
	echo Replace the value of yourgithubusername with your GitHub username and re-run
	pause
	exit 
)

sam.cmd deploy --stack-name %PROJECT_NAME%-%GITHUB_USERNAME%-application --template-file  ./Application/template.yml --s3-bucket %PROJECT_NAME%-%GITHUB_USERNAME%-artifacts --capabilities CAPABILITY_NAMED_IAM CAPABILITY_AUTO_EXPAND --parameter-overrides \"ProjectName\"=\"%PROJECT_NAME%-%GITHUB_USERNAME%\"

pause
