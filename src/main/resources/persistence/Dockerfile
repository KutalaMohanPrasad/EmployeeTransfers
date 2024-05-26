FROM postgres:15

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 12345