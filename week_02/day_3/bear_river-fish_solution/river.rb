class River

  attr_reader :name

  def initialize(name, fish)
    @name = name
    @fish = fish
  end

  def fish_count()
    return @fish.count()
  end

  def supply_fish()
    return @fish.pop()
  end



end
