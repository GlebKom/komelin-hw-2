create table if not exists metrics(
    id int primary key generated by default as identity,
    method_name varchar not null,
    avg_runtime float,
    exceptions_occurred bigint,
    longest_runtime float
)