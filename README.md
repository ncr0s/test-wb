# test-wb

### Launching tests from a terminal

### Local launch of tests

#### Local launch of tests using parameters from property file

```
gradle clean test -Denv={property file from the ./test/resources}
```

#### Local launch of tests using parameters from property file test

```
gradle clean test
```

#### Description of parameters for running tests
> <code>-DbrowserName</code> browser name
>
> <code>-DbrowserVersion</code> browser version
>
> <code>-DbaseUrl</code> url of the testing stand
>
> <code>-DbrowserSize</code> browser resolution
>
> <code>-DpageLoadTimeout</code> page load timeout
>
> <code>-DelementTimeout</code> timeout for loading the page element
>
> <code>-DremoteUrl</code> url of the remote service