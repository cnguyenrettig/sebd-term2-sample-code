echo off
echo GITHUB_USERNAME is %GITHUB_USERNAME%
echo UNIT_TWO_PROJECT_NAME is %UNIT_TWO_PROJECT_NAME%

if %GITHUB_USERNAME%==yourusernameinlowercase (
	echo Replace the environment variable GITHUB_USERNAME with your GitHub user name and re-run
	pause
	exit 
)

sam.cmd deploy --stack-name %UNIT_TWO_PROJECT_NAME%-%GITHUB_USERNAME%-application --template-file  ./Application/template.yml --s3-bucket %UNIT_TWO_PROJECT_NAME%-%GITHUB_USERNAME%-artifacts --capabilities CAPABILITY_NAMED_IAM CAPABILITY_AUTO_EXPAND --parameter-overrides \"ProjectName\"=\"%UNIT_TWO_PROJECT_NAME%-%GITHUB_USERNAME%\"

pause
