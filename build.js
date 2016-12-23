#!/usr/bin/jjs -fv

var version = $ENV.VERSION;
var username = $ENV.USERNAME;
var password = $ENV.PASSWORD;

var registry = "disruptor.ninja:30500";
var image = "robertbrem/battleapp";
var completeImageName = registry + "/" + image + ":" + version;

var dockerBuild = "docker build -t " + completeImageName + " .";
execute(dockerBuild);

var dockerLogin = "docker login " + registry + " --username=" + username + " --password=" + password;
execute(dockerLogin);

var push = "docker push " + completeImageName;
execute(push);

function execute(command) {
    $EXEC(command);
    print($OUT);
    print($ERR);
}