#!/usr/bin/jjs -fv

var version = $ENV.VERSION;
var username = $ENV.REGISTRY_USERNAME;
var password = $ENV.REGISTRY_PASSWORD;
var email = $ENV.REGISTRY_EMAIL;

var registry = "disruptor.ninja:30500";
var image = "robertbrem/battleapp";
var completeImageName = registry + "/" + image + ":" + version;

var dockerBuild = "docker build -t " + completeImageName + " .";
execute(dockerBuild);

var dockerLogin = "docker login --username=" + username + " --password=" + password + " --email=" + email + " " + registry;
execute(dockerLogin);

var push = "docker push " + completeImageName;
execute(push);

function execute(command) {
    $EXEC(command);
    print($OUT);
    print($ERR);
}