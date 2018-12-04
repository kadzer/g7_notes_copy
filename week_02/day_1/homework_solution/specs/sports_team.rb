require('minitest')
require('minitest/autorun')
require_relative('../sportsteam.rb')

class TestSportsTeam < MiniTest::Test

  def setup
    players = ["Dele Alli", "Harry Kane", "Moussa Dembele"]
    @team = SportsTeam.new("Spurs", players, "Pochettino")
  end

  def test_has_name
    team_name = @team.get_name()
    assert_equal("Spurs", team_name)
  end

  def test_has_coach
    coach = @team.get_coach()
    assert_equal("Pochettino", coach)
  end

  def test_has_players
    players = @team.get_players()
    assert_equal(3, players.count())
  end

  def test_add_player
    @team.add_player("Ali Kane")
    players = @team.get_players()
    assert_equal(4, players.count())
  end

  def test_is_player
    result = @team.is_player("Bob")
    assert_equal(false, result)
  end

  def test_win_loss
    @team.has_won(true)
    points = @team.get_points()
    assert_equal(3, points)
  end

end
