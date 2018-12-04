class Band

attr_reader :name

  def initialize(name, musicians)
    @name = name
    @musicians = musicians
  end

  def perform(song_title)
    performance = []
    for musician in @musicians
      performance << musician.play_song(song_title)
    end
    return performance
  end

end
