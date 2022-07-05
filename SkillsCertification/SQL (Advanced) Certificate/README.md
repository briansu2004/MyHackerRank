# SQL (Advanced) Skills Certification Test

```bash
1. Weather Analysis

There is a table with daily weather data over the last 6 months of 2020, including the maximum, minimum, and average temperatures.

Write a query that gives month, monthly maximum, monthly minimum, monthly average temperatures for the six months.

Note: Round the average to the nearest integer.

Schema

There is 1 table: temperature_records.

temperature_records
Name Type Description
record_date varchar(10) date of the record
data_type varchar(3) type key ( 'min', 'max' or 'avg')
data_value int value

Sample Data Tables

temperature_records

record_date data_type data_value
2020-07-01 max 92
2020-07-01 min 71
2020-07-01 avg 74
2020-07-02 max 90
2020-07-02 min 67
2020-07-02 avg 77
2020-07-03 max 92
2020-07-03 min 72
2020-07-03 avg 82
2020-07-04 max 97
2020-07-04 min 72
2020-07-04 avg 82
2020-07-05 max 93
2020-07-05 min 75
2020-07-05 avg 78
2020-07-06 max 95
2020-07-06 min 76
2020-07-06 avg 79
2020-07-07 max 95
2020-07-07 min 70
2020-07-07 avg 78
2020-07-08 max 91
2020-07-08 min 73
2020-07-08 avg 77
2020-07-09 max 93
2020-07-09 min 72
2020-07-09 avg 79
2020-07-10 max 92
2020-07-10 min 75
2020-07-10 avg 78
2020-07-11 max 90
2020-07-11 min 75
2020-07-11 avg 78
2020-07-12 max 92
2020-07-12 min 68
2020-07-12 avg 76
2020-07-13 max 92
2020-07-13 min 69
2020-07-13 avg 73
2020-07-14 max 91
2020-07-14 min 68
2020-07-14 avg 74
2020-07-15 max 92
2020-07-15 min 69
2020-07-15 avg 75
2020-07-16 max 92
2020-07-16 min 74
2020-07-16 avg 76
2020-07-17 max 88
2020-07-17 min 74
2020-07-17 avg 79
2020-07-18 max 98
2020-07-18 min 75
2020-07-18 avg 77
2020-07-19 max 98
2020-07-19 min 75
2020-07-19 avg 83
2020-07-20 max 100
2020-07-20 min 81
2020-07-20 avg 86
2020-07-21 max 100
2020-07-21 min 77
2020-07-21 avg 82
2020-07-22 max 98
2020-07-22 min 74
2020-07-22 avg 77
2020-07-23 max 97
2020-07-23 min 73
2020-07-23 avg 80
2020-07-24 max 94
2020-07-24 min 74
2020-07-24 avg 79
2020-07-25 max 86
2020-07-25 min 71
2020-07-25 avg 78
2020-07-26 max 92
2020-07-26 min 77
2020-07-26 avg 83
2020-07-27 max 95
2020-07-27 min 75
2020-07-27 avg 79
2020-07-28 max 96
2020-07-28 min 77
2020-07-28 avg 84
2020-07-29 max 93
2020-07-29 min 73
2020-07-29 avg 78
2020-07-30 max 93
2020-07-30 min 76
2020-07-30 avg 83
2020-07-31 max 95
2020-07-31 min 73
2020-07-31 avg 74
 

OUTPUT
month max min avg
7 100 67 79
```

```sql
select maxmin.m2, maxmin.max, maxmin.min, avg.avg
from 
(
  select
  CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) as m1
  , ROUND(avg(data_value)) as avg
  from temperature_records
  where SUBSTRING(record_date, 1, 4) = '2020'
  and CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) > 6
  and CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) <= 12
  and data_type = 'avg'
  group by CONVERT(SUBSTRING(record_date, 6, 2), SIGNED)
) as avg
inner JOIN
(
  select CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) as m2
  , max(data_value) as max
  , min(data_value) as min
  from temperature_records
  where SUBSTRING(record_date, 1, 4) = '2020'
  and CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) > 6
  and CONVERT(SUBSTRING(record_date, 6, 2), SIGNED) <= 12
  group by CONVERT(SUBSTRING(record_date, 6, 2), SIGNED)
) as maxmin
on avg.m1 = maxmin.m2
;
```

![1657034432695](image/README/1657034432695.png)

![1657034459088](image/README/1657034459088.png)

![1657034467774](image/README/1657034467774.png)

```bash
2. Crypto Market Transactions Monitoring

As part of a cryptocurrency trade monitoring platform, create a query to return a list of suspicious transactions.

Suspicious transactions are defined as:

a series of two or more transactions occur at intervals of an hour or less
they are from the same sender
the sum of transactions in a sequence is 150 or greater
 
A sequence of suspicious transactions may occur over time periods greater than one hour. As an example, there are 5 transactions from one sender for 30 each. They occur at intervals of less than an hour between from 8 AM to 11 AM. These are suspicious and will all be reported as one sequence that starts at 8 AM, ends at 11 AM, with 5 transactions that sum to 150.

The result should have the following columns: sender, sequence_start, sequence_end, transactions_count, transactions_sum

sender is the sender's address.
sequence_start is the timestamp of the first transaction in the sequence.
sequence_end is the timestamp of the last transaction in the sequence.
transactions_count is the number of transactions in the sequence.
transactions_sum is the sum of transaction amounts in the sequence, to 6 places after the decimal.
 
Order the data ascending, first by sender, then by sequence_start, and finally by sequence_end.

Schema

There is 1 table:
 
transactions
name type description
dt VARCHAR(19) Transaction timestamp
sender VARCHAR(49) Sender address
recipient VARCHAR(49) Recipient address
amount DECIMAL(9,6) Transaction amount
 
Sample Data Tables

For the sample data in tables:

transactions
dt sender recipient amount
2021-07-24 15:09:30 0xb4e92f4b58ba815f791dc6622385a00914eb03f0 0xd431d8e9b1c4292cb68f36afe8a0fc129c3e333f 29.441485
2021-07-24 11:29:33 0x15112cc45c07d2e771ddefbea3a594d223546e59 0xedbb2bc7b8c8d7539da5000941cbd081f1cde7aa 40.275617
2021-07-24 18:22:35 0x15112cc45c07d2e771ddefbea3a594d223546e59 0xcf0e6ae9222da42524f701b116d79286072531c9 52.302129
2021-07-24 20:22:15 0x15112cc45c07d2e771ddefbea3a594d223546e59 0x1b9efbae8f0e2a3e3ae8e7957ca628165f081f64 79.887726
2021-07-24 03:29:30 0x0ecfdc85acd320fffd5b95d08a61bd0768026609 0xe8db8ad08ba07bd0ecf94865341c9b293ce45ebc 64.080557
2021-07-24 08:49:28 0x15112cc45c07d2e771ddefbea3a594d223546e59 0xe7cd0c36f0ca4f521f50d23c013ea61b606c7598 88.865810
2021-07-24 08:39:17 0x15112cc45c07d2e771ddefbea3a594d223546e59 0x035324a8d3791e7c2704002536e0b589f90a83e3 68.711233
2021-07-24 23:10:48 0x0ecfdc85acd320fffd5b95d08a61bd0768026609 0x6fdd220b9ccdc0ba61fd7ba205fa6eabc3535991 61.848246
2021-07-24 02:54:49 0x15112cc45c07d2e771ddefbea3a594d223546e59 0xa6950929dbb9309ddd8f7d8f2ba743462094a043 39.160744
2021-07-24 04:22:20 0x02df41ac455ec348da7ab1a5e4520f8917c4b41c 0x14cc6106f2119832b14cd0a94212576910b29901 48.436863
2021-07-24 01:09:53 0x0ecfdc85acd320fffd5b95d08a61bd0768026609 0xb9b70229d3ae4c347acaa5ca92e82e7fc5cdd3a5 24.515494
2021-07-24 06:49:27 0x02df41ac455ec348da7ab1a5e4520f8917c4b41c 0x541809f0de9f44dde6bdc43936ab5c545f995489 93.499378
2021-07-24 21:32:13 0xf0a1123e6a92c849e556d4aa9ef49f798b2b7a23 0x74bfa5f31f3e1e9f0fd6ddda7b95b620fcdffff0 95.472426
2021-07-24 14:33:16 0xf0a1123e6a92c849e556d4aa9ef49f798b2b7a23 0xfabf800fb3da10e966ed1bdb8251653e016e8c5c 44.122483
2021-07-24 02:33:55 0x0ecfdc85acd320fffd5b95d08a61bd0768026609 0x49d194a1470469902f0b15418d1a177496ac378f 81.893268
2021-07-24 11:02:36 0xb4e92f4b58ba815f791dc6622385a00914eb03f0 0x80e489b6539deb9a7f9732fb8c6a80dbaf21e02c 72.400256
2021-07-24 12:47:15 0x15112cc45c07d2e771ddefbea3a594d223546e59 0x1da67b3cf97ba80f11eccd1578cb9e604afeae38 94.324919
2021-07-24 04:03:57 0x15112cc45c07d2e771ddefbea3a594d223546e59 0x229b4851ddaf796b2d7a54b17dbaf531ac4eb576 85.542132
2021-07-24 12:28:00 0x15112cc45c07d2e771ddefbea3a594d223546e59 0x9ebc1faa9d07c57d97d0142622fe6e6c60c9d489 40.769475
2021-07-24 06:39:08 0x02df41ac455ec348da7ab1a5e4520f8917c4b41c 0xd73a609664f0f4420d6b2572ed01457d813bc230 82.201180
 

the expected output is:

sender ▲ sequence_start ▲ sequence_end ▲ transactions_count transactions_sum
0x02df41ac455ec348da7ab1a5e4520f8917c4b41c 2021-07-24 06:39:08 2021-07-24 06:49:27 2 175.700558
0x15112cc45c07d2e771ddefbea3a594d223546e59 2021-07-24 08:39:17 2021-07-24 08:49:28 2 157.577043
0x15112cc45c07d2e771ddefbea3a594d223546e59 2021-07-24 11:29:33 2021-07-24 12:47:15 3 175.370011
```
