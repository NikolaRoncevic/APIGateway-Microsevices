#!/bin/sh

./consul agent -config-dir=/consul-config &

java -jar composerservice-1.0.0.jar