class Library

  def initialize()
    @books = []
  end

  def get_books()
    return @books
  end

  def add_book(new_book)
    @books << new_book
  end

  def get_book_by_title(title)
    for book in @books
      if book[:title] == title
        return book
      end
    end
  end

  def add_book_by_title(new_title)
    new_book = {
      title: new_title,
      rental_details: {
        student_name: "",
        date: ""
      }
    }
    @books.push(new_book)
  end

  def loan_book(title, student, date)
    book = get_book_by_title(title)
    book[:rental_details][:student_name] = student
    book[:rental_details][:date] = date
  end
  
end
