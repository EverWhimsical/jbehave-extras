
echo $GPG_SECRET_KEYS | base64 --decode | $GPG_EXECUTABLE --import
echo $GPG_OWNERTRUST | base64 --decode | $GPG_EXECUTABLE --import-ownertrust
echo "TRAVIS_BRANCH $TRAVIS_BRANCH | is_release_candidate $is_release_candidate"
if [[ "$TRAVIS_BRANCH" == "master" && $is_release_candidate != 1 ]]; then
    echo "Skipping deploy since branch is master and it is SNAPSHOT release"
elif [[ "$TRAVIS_BRANCH" == "develop" && $is_release_candidate = 1 ]]; then
    echo "Skipping deploy since branch is develop and it is not a SNAPSHOT release"
else
    echo "About to run deploy"
    mvn deploy --settings utilities/.maven.xml -DskipTests=true -B -U -Prelease
fi
