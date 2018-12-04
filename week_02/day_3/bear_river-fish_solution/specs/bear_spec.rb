require('minitest/autorun')
require('minitest/rg')

require_relative('../bear.rb')
require_relative('../river.rb')
require_relative('../fish.rb')

class BearTest < MiniTest::Test

  def setup()
    @bear = Bear.new("Winston", "Grizzly")
    @fish1 = Fish.new("Sammy")
    @fish2 = Fish.new("Nemo")
    @river = River.new("Amazon", [@fish1, @fish2])
  end

  def test_belly_starts_empty()
    assert_equal(0, @bear.food_count())
  end

  def test_bear_can_get_fish_from_river()
    @bear.take_fish(@river)
    assert_equal(1, @bear.food_count())
    assert_equal(1, @river.fish_count())
  end




end
