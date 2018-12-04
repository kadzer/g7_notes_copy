class SportsTeam

  def initialize(name, players, coach)
    @name = name
    @players = players
    @coach = coach
    @points = 0
  end

  def get_name
    return @name
  end

  def get_players
    return @players
  end

  def get_coach
    return @coach
  end

  def get_points
    return @points
  end

  def set_coach(new_coach)
    @coach = new_coach
  end

  def add_player(player)
    @players << player
  end

  def is_player(player)
    return @players.include?(player)
  end

  def has_won(result)
    if result == true
      @points += 3
    end
  end
  
end
