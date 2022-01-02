
-- основная таблица с котировками акций
CREATE TABLE IF NOT EXISTS stock_market_data
(
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP WITHOUT TIME ZONE,
    ticker_id INT REFERENCES stock_market_tickers (id),
    timeframe_id INT REFERENCES timeframes (id),
    open_price REAL,
    high_price REAL,
    low_price REAL,
    close_price REAL,
    volume BIGINT,
    UNIQUE (start_date, ticker_id, timeframe_id)
);

-- таблица тикеров акций (напр. GAZP, SBER и т.д.)
CREATE TABLE IF NOT EXISTS stock_market_tickers
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE,
    description VARCHAR(150)
);

-- таблица таймфреймов (напр. HOUR, DAY, WEEK и т.д.)
CREATE TABLE IF NOT EXISTS stock_market_timeframes
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE,
    description VARCHAR(150)
);

