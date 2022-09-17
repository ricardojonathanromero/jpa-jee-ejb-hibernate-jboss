#!/bin/bash
echo "downloading postgresql driver (42.5) ..."
curl https://jdbc.postgresql.org/download/postgresql-42.5.0.jar -o /opt/resources/postgres.jar -s
echo "executing data source script ..."
/opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/resources/jndi.cli
echo "data source added successfully :)"
echo