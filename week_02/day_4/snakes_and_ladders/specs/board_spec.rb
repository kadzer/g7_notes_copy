require("minitest/autorun")
require("minitest/rg")

require_relative("../sladder.rb")
require_relative("../board.rb")

class BoardTest < MiniTest::Test

  def setup()
    @ladder = Sladder.new(6, 3)
    @snake = Sladder.new(43, -9)
    @board = Board.new(50, [@ladder, @snake])
  end

  def test_can_get_number_of_squares()
    assert_equal(50, @board.number_of_squares())
  end

  def test_landed_on_ladder()
    result =  @board.check_snake_or_ladder(6)
    assert_equal(3, result)
  end

  def test_no_snake_or_ladder_nil()
    result = @board.check_snake_or_ladder(8)
    assert_equal(0, result)
  end
end
