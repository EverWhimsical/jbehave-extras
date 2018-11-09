echo $GPG_SECRET_KEYS | base64 --decode | $GPG_EXECUTABLE --import
echo $GPG_OWNERTRUST | base64 --decode | $GPG_EXECUTABLE --import-ownertrust
echo "TRAVIS_BRANCH $TRAVIS_BRANCH | is_release_candidate $is_release_candidate"
if [[ "$TRAVIS_BRANCH" == "master" && $is_release_candidate != 1 ]]; then
    echo "Skipping deploy since it is not a release and branch is master"
else
    echo "About to run deploy"
    mvn deploy --settings scripts/.maven.xml -DskipTests=true -B -U -Prelease
fi
