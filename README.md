# kinesis-flink-hello-world


AWS Kinesis and Apache Flink Example

## `.env`

Need an environment file to run, recreate `.env` from `.env.example` and put relevant credentials and you're good to go.

## Kinesis Producer 

```sh
aws kinesis put-record --stream-name <yourCreatedStreamNameHere> --data '{"hello":"test"}' --partition-key "KEY0"
```

## Disclaimer

If you're using `aws v2` then have to add this to config (`~/.aws/config`).

```
cli_binary_format=raw-in-base64-out
```

## Flink Consumer

Just run the code. And then run the producer.


