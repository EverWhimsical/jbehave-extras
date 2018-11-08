echo $GPG_SECRET_KEYS | base64 --decode | $GPG_EXECUTABLE --import
echo $GPG_OWNERTRUST | base64 --decode | $GPG_EXECUTABLE --import-ownertrust
echo "About to run deploy"
mvn deploy --settings scripts/.maven.xml -DskipTests=true -B -U -Prelease
