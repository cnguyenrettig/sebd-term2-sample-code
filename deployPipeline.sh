branch=main

source ./setupEnvironment.sh


if [ -z "$GITHUB_USERNAME" ] || [ "$GITHUB_USERNAME" == "yourusernameinlowercase" ] ; then
  echo "Your environment variable GITHUB_USERNAME is not properly configured.  Make sure that you have filled out setupEnvironment.sh and that script is set to run as part of your PATH"
  exit 1
fi

 

echo "Outputting parameters for the pipeline..."
echo "Project name: $UNIT_TWO_PROJECT_NAME"
echo "Github UserName: $GITHUB_USERNAME"
echo "Branch: $branch"


if [ "$OSTYPE" == "msys" ] 
then
  echo "Deploying Pipeline on Windows"
  ./deployWindowsPipeline.bat
else
  echo "Deploying Pipeline on MacOS/Linux"
  /usr/local/bin/sam deploy --stack-name $UNIT_TWO_PROJECT_NAME-$GITHUB_USERNAME-application --template-file  ./Application/template.yml --s3-bucket $UNIT_TWO_PROJECT_NAME-$GITHUB_USERNAME-artifacts --capabilities CAPABILITY_NAMED_IAM CAPABILITY_AUTO_EXPAND --parameter-overrides \"ProjectName\"=\"$UNIT_TWO_PROJECT_NAME-$GITHUB_USERNAME\"
fi