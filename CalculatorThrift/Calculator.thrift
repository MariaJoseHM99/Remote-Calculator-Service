struct Result {
    1: i32 result;
    2: string errorMessage;
}


service Calculator {
    Result Sum( 1:i32 firstDigit, 2:i32 secondDigit)
    Result Subtract (1:i32 firstDigit, 2:i32 secondDigit)
    Result Multiply( 1:i32 firstDigit, 2:i32 secondDigit)
    Result Divide( 1:i32 firstDigit, 2:i32 secondDigit)
}
