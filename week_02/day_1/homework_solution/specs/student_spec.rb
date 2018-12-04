require('minitest')
require('minitest/autorun')
require_relative('../student.rb')

class TestStudent < MiniTest::Test

  def setup
    @student = Student.new("Tanny", "G7")
  end

  def test_has_name
    result = @student.get_name()
    assert_equal("Tanny", result)
  end

  def test_has_cohort
    result = @student.get_cohort()
    assert_equal("G7", result)
  end

  def test_set_name
    @student.set_name("Fiona")
    result = @student.get_name()
    assert_equal("Fiona", result)
  end

  def test_set_cohort
    @student.set_cohort("E7")
    result = @student.get_cohort()
    assert_equal("E7", result)
  end

  def test_can_talk
    result = @student.talk()
    assert_equal("I love Ruby!", result)
  end

  def test_favourite_language
    result = @student.favourite_language("Java")
    assert_equal("My favourite language is Java", result)
  end

end
