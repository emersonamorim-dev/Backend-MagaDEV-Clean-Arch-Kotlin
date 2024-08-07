-- Inserir usuário
INSERT INTO users (username, password, email) VALUES
    ('admin', '{bcrypt}$2a$10$Qj.K5q.Y6BlY/FmI/ScU5.lJcfMi1Xfg.8nLIF3fED2FexO9lQzOa', 'admin@example.com');

-- Inserir produtos
INSERT INTO products (name, description, price, brand, category, state) VALUES
                                                                            ('Tênis Nike', 'Confortável e estiloso', 299.99, 'Nike', 'Calçados', 'Novo'),
                                                                            ('Camiseta Adidas', 'Leve e respirável', 150.00, 'Adidas', 'Vestuário', 'Novo'),
                                                                            ('Calça Jeans Levis', 'Durável e moderna', 199.99, 'Levis', 'Vestuário', 'Novo'),
                                                                            ('Casaco North Face', 'Ideal para o frio', 450.00, 'North Face', 'Vestuário', 'Novo'),
                                                                            ('Jaqueta Impermeável', 'Perfeita para chuva', 300.00, 'Columbia', 'Vestuário', 'Novo'),
                                                                            ('Boné Snapback', 'Estiloso e ajustável', 80.00, 'New Era', 'Acessórios', 'Novo');

-- Inserir mais 94 produtos com variação de detalhes
DO $$
DECLARE
i INTEGER;
BEGIN
FOR i IN 1..94 LOOP
        INSERT INTO products (name, description, price, brand, category, state) VALUES
        ('Produto ' || i, 'Descrição ' || i, (RANDOM() * (500-50) + 50)::DECIMAL(10,2), 'Marca ' || MOD(i, 10), 'Categoria ' || MOD(i, 5), 'Estado ' || MOD(i, 3));
END LOOP;
END $$;
