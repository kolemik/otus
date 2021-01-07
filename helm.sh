#!/bin/sh

# pack templates from dz02-chart to helm artifact
helm package dz02-chart

# move artifact to github-published directory
mv dz02-chart-0.1.0.tgz docs/

# recreate index.yaml file
helm repo index docs --url https://kolemik.github.io/otus
