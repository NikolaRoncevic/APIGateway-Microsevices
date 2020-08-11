#!/bin/sh

./consul agent -config-dir=/consul-config &

java -jar storageservice-1.0.0.jar