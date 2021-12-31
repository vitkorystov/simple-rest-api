

CREATE TABLE stock_market_prices
(
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP WITHOUT TIME ZONE,
    ticker_id INT REFERENCES stock_market_tickers (id),
    timeframe_id INT REFERENCES timeframes (id),
    open_price REAL,
    high_prices REAL,
    low_prices REAL,
    close_prices REAL,
    volume BIGINT
);

CREATE TABLE stock_market_tickers
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);



