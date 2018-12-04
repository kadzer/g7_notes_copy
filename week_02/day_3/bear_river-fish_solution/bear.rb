class Bear

  def initialize(name, type)
    @name = name
    @type = type
    @belly = []
  end

  def food_count()
    return @belly.size()
  end

  def take_fish(river)
    eaten_fish = river.supply_fish()
    @belly.push(eaten_fish)
  end
end
