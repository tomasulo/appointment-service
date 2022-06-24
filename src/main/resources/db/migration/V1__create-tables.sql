CREATE TABLE REASONS
(
    id SERIAL NOT NULL,
    title text,
    description text,
    PRIMARY KEY (id)
);

CREATE TABLE APPOINTMENTS
(
    id SERIAL NOT NULL,
    channel text,
    notes text,
    symptoms text,
    video_call_link text,
    cancellation_link text,
    start_time timestamp with time zone,
    end_time timestamp with time zone,
    patient_id text,
    practice_id text,
    staff_id text,
    reason_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (reason_id) references REASONS(id)
);
