BEGIN;

-- Limpiamos las tablas y reiniciamos secuencias
TRUNCATE TABLE public.addresses, public.users RESTART IDENTITY CASCADE;

-- Insertar usuarios
INSERT INTO public.users (id, created_at, email, name, password, phone, tax_id) VALUES
                                                                                    ('58518025-c54e-4a99-95d7-e3df660a2005', '2026-03-14 01:42:50.929498+03', 'miguuel@mail.com', 'Miguel Lopez', 'MyvB/ulQPjOVhlMSFryavg==', '+529711137581', 'UIMM000116FM7'),
                                                                                    ('3ad7bc18-929d-4e53-90c6-dbc19ce117ec', '2026-03-14 02:06:07.56326+03', 'juan@mail.com', 'Juan', 'MyvB/ulQPjOVhlMSFryavg==', '+529711137582', 'UIMM000116FM9'),
                                                                                    ('d4e4fcf0-1234-4567-890a-bcde12345678', '2026-03-14 03:00:00+03', 'maria@mail.com', 'Maria', 'SomeHashedPassword==', '+521234567890', 'XAXX010101000');

-- Insertar direcciones (user_id debe coincidir con los usuarios insertados)
INSERT INTO public.addresses (id, country_code, name, street, user_id) VALUES
                                                                           (1, 'mex', 'workaddress', 'street No. 1', '58518025-c54e-4a99-95d7-e3df660a2005'),
                                                                           (2, 'mex', 'homeaddress', 'street No. 2', '58518025-c54e-4a99-95d7-e3df660a2005'),
                                                                           (3, 'us', 'homeaddress', 'street No. 3', '3ad7bc18-929d-4e53-90c6-dbc19ce117ec'),
                                                                           (4, 'mex', 'workaddress', 'street No. 4', '3ad7bc18-929d-4e53-90c6-dbc19ce117ec'),
                                                                           (5, 'us', 'homeaddress', 'street No. 5', 'd4e4fcf0-1234-4567-890a-bcde12345678');

-- Ajustar secuencia según el último id de addresses
SELECT pg_catalog.setval('public.addresses_id_seq', 5, true);

COMMIT;