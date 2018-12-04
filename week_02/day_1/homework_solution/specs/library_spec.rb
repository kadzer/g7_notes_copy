require('minitest')
require('minitest/autorun')
require_relative('../library.rb')

class TestLibrary < MiniTest::Test

  def setup
    @library = Library.new()
    @lotr = {
      title: "lord_of_the_rings",
      rental_details: {
        student_name: "Jeff",
        date: "01/12/18"
      }
    }
    @library.add_book(@lotr)
  end

  def test_get_books
    result = @library.get_books()
    assert_equal(1, result.count())
  end

  def test_add_book
    new_book = {
      title: "the hobbit",
      rental_details: {
        student_name: "Maria",
        date: "02/12/18"
      }
    }
    @library.add_book(new_book)

    result = @library.get_books()
    assert_equal(2, result.count())
  end

  def test_get_book_by_title
    result = @library.get_book_by_title("lord_of_the_rings")
    assert_equal(@lotr, result)
  end

  def test_can_add_book_by_title
    @library.add_book_by_title("Learn 2 Code")
    book = @library.get_book_by_title("Learn 2 Code")

    expected_book = {
      title: "Learn 2 Code",
      rental_details: {
        student_name: "",
        date: ""
      }
    }

    assert_equal(expected_book, book)
  end

  def test_can_change_rental_details
    @library.loan_book("lord_of_the_rings", "Maria", "05/12/18")

    found_book = @library.get_book_by_title("lord_of_the_rings")

    expected_book = {
      title: "lord_of_the_rings",
      rental_details: {
        student_name: "Maria",
        date: "05/12/18"
      }
    }

    assert_equal(expected_book, found_book)
  end

end
