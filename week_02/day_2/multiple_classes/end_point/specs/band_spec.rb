require("minitest/autorun")
require("minitest/rg")

require_relative("../band")
require_relative("../musician")
require_relative("../instrument")

class BandTest < MiniTest::Test

  def setup
    piano = Instrument.new("piano")
    bass = Instrument.new("bass guitar")
    guitar = Instrument.new("guitar")
    drums = Instrument.new("drums")

    john = Musician.new("John Lennon", piano)
    paul = Musician.new("Paul McCartney", bass)
    george = Musician.new("George Harrison", guitar)
    ringo = Musician.new("Ringo Starr", drums)

    @beatles = Band.new("The Beatles", [john, paul, george, ringo])
  end

  def test_band_has_name
    assert_equal("The Beatles", @beatles.name)
  end 

  def test_band_can_play_song
    expected = [
      "Plink plonk... I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
    ]
    assert_equal(expected, @beatles.perform("Hey Jude"))
  end

end
