$:.push('gen-rb')
require 'thrift'
require 'calculator'
require 'calculator_types'

class CalculatorHandler

  def Sum(firstDigit,secondDigit)
        result = Result.new
        result.result = firstDigit + secondDigit
    return result
  end

  def Subtract(firstDigit,secondDigit)
        result = Result.new
        result.result = firstDigit - secondDigit
    return result
  end  

    def Multiply(firstDigit,secondDigit)
        result = Result.new
        result.result = firstDigit * secondDigit
     return result 
    end


    def Divide(firstDigit,secondDigit)
        result = Result.new
        if secondDigit == 0
            result.result = 0
            result.errorMessage = "No es posible dividirlo entre 0"
        else
            result.result = firstDigit/secondDigit
        end
        return result
    end

end

handler = CalculatorHandler.new()
processor = Calculator::Processor.new(handler)
transport = Thrift::ServerSocket.new(8080)
transportFactory = Thrift::BufferedTransportFactory.new()
server = Thrift::SimpleServer.new(processor, transport, transportFactory)

puts "Starting the server..."
server.serve()
puts "done." 