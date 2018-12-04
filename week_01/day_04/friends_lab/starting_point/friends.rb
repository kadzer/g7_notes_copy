def get_name(person)
  return person[:name]
end

def get_favourite(thing, person)
  return person[:favourites][thing]
end

def likes_to_eat(person, food)
  return person[:favourites][:snacks].include?(food)
end

def add_friend(person, new_friend)
  person[:friends].push(new_friend)
end

def remove_friend(person, removable_friend)
  person[:friends].delete(removable_friend)
end

def total_money(group)
  total = 0
  for person in group
    total += person[:monies]
  end
  return total
end

def loan(loaner, loanee, amount)
  loaner[:monies] -= amount
  loanee[:monies] += amount
end

def all_items(group, items)
  arr = []
  for person in group
    arr.concat(get_favourite(items, person))
  end
  return arr
end

def get_loners(group)
  arr = []
  for person in group
    if person[:friends].length() < 1
      arr.push(person)
    end
  end
  return arr
end
