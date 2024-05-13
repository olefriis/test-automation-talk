describe("Calculator", function() {
  var calculator;

  beforeEach(function() {
    calculator = new Calculator();
  });

  it("should be able to add two numbers", function() {
    expect(calculator.add(1, 2)).toEqual(3);
  });

  it("should be able to subtract two numbers", function() {
    expect(calculator.subtract(5, 2)).toEqual(3);
  });

  it("should be able to multiply two numbers", function() {
    expect(calculator.multiply(2, 3)).toEqual(6);
  });

  it("should be able to divide two numbers", function() {
    expect(calculator.divide(6, 2)).toEqual(3);
  });

  it("should throw an error when dividing by zero", function() {
    expect(function() { calculator.divide(5, 0); }).toThrow(new Error("Division by zero"));
  });
});
