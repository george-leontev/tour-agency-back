ALTER TABLE business.excursion
    ADD COLUMN IF NOT EXISTS description VARCHAR(256);

ALTER TABLE business.excursion
    ADD COLUMN IF NOT EXISTS location VARCHAR(256);