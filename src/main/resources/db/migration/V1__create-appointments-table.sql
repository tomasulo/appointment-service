CREATE TABLE APPOINTMENT
(
    id SERIAL NOT NULL,
    notes text,
    video_call_link text,
    start_date_time timestamp with time zone,
    created_at timestamp with time zone,
    modified_at timestamp with time zone,
    PRIMARY KEY (id)
);
