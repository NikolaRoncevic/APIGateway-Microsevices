#!/bin/sh

./consul agent -config-dir=/consul-config &

java -jar orderservice-1.0.0.jar